package dev.alfrendosilalahi.leafbank.ms__account.controller;

import dev.alfrendosilalahi.leafbank.ms__account.config.properties.AccountConfigProperties;
import dev.alfrendosilalahi.leafbank.ms__account.dto.request.CustomerRequestDto;
import dev.alfrendosilalahi.leafbank.ms__account.dto.request.UpdateAccountRequestDto;
import dev.alfrendosilalahi.leafbank.ms__account.dto.response.AccountResponseDto;
import dev.alfrendosilalahi.leafbank.ms__account.dto.response.ErrorBaseResponseDto;
import dev.alfrendosilalahi.leafbank.ms__account.dto.response.SuccessBaseResponseDto;
import dev.alfrendosilalahi.leafbank.ms__account.service.AccountService;
import dev.alfrendosilalahi.leafbank.ms__account.utils.ResponseStatus;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeoutException;

@Tag(
	name = "Account API endpoints for Eazy Bank Account Microservice", 
	description = "Account API endpoints for Eazy Bank Account Microservice"
)
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

	private static final Logger log = LoggerFactory.getLogger(AccountController.class);

	@Value("${build.version}")
	private String buildVersion;

	private final AccountService accountService;

	private final Environment environment;

	private final AccountConfigProperties accountConfigProperties;

	@Operation(summary = "Create a new account", description = "Create a new account for a customer")
	@ApiResponse(responseCode = "201", description = "Http Status CREATED")
	@PostMapping
	public ResponseEntity<SuccessBaseResponseDto<Void>> createAccount(
			@RequestBody @Valid CustomerRequestDto customerRequestDto) {
		accountService.createAccount(customerRequestDto);
		return SuccessBaseResponseDto.createSuccessBaseResponseDto(
				HttpStatus.CREATED, HttpStatus.CREATED.value(), ResponseStatus.OK.name());
	}

	@Operation(summary = "Get account information by mobile number", description = "Get account information by mobile number")
	@ApiResponse(responseCode = "200", description = "Http Status OK")
	@GetMapping
	public ResponseEntity<SuccessBaseResponseDto<AccountResponseDto>> getAccount(
			@RequestParam String mobileNumber) {
		AccountResponseDto response = accountService.getAccount(mobileNumber);
		return SuccessBaseResponseDto.createSuccessBaseResponseDto(
				HttpStatus.OK, HttpStatus.OK.value(), ResponseStatus.OK.name(), response);
	}

	@Operation(summary = "Update account information", description = "Update account information")
	@ApiResponse(responseCode = "200", description = "Http Status OK")
	@PutMapping
	public ResponseEntity<SuccessBaseResponseDto<Void>> updateAccount(
			@RequestBody @Valid UpdateAccountRequestDto updateAccountRequestDto) {
		accountService.updateAccount(updateAccountRequestDto);
		return SuccessBaseResponseDto.createSuccessBaseResponseDto(
				HttpStatus.OK, HttpStatus.OK.value(), ResponseStatus.OK.name());
	}

	@Operation(summary = "Delete account", description = "Delete account")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Http Status OK"),
			@ApiResponse(responseCode = "404", description = "Http Status NOT_FOUND", content = @Content(schema = @Schema(implementation = ErrorBaseResponseDto.class)))
	})
	@DeleteMapping
	public ResponseEntity<SuccessBaseResponseDto<Void>> deleteAccount(@RequestParam Long id) {
		accountService.deleteAccount(id);
		return SuccessBaseResponseDto.createSuccessBaseResponseDto(
				HttpStatus.OK, HttpStatus.OK.value(), ResponseStatus.OK.name());
	}

	@Retry(name = "getBuildInfo", fallbackMethod = "getBuildInfoFallback")
	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildInfo() throws TimeoutException {
		log.info("getBuildInfo() invoked");
		throw new TimeoutException();
//		return ResponseEntity.ok(buildVersion);
	}

	public ResponseEntity<String> getBuildInfoFallback(Throwable throwable) {
		log.info("getBuildInfoFallback() invoked");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("0.9");
	}

	@GetMapping("/java-version")
	public ResponseEntity<String> getJavaVersion() {
		return ResponseEntity.ok(
				String.format("%s ~ %s", environment.getProperty("JAVA_HOME"), environment.getProperty("MAVEN_HOME")));
	}

	@GetMapping("/general-info")
	public ResponseEntity<String> getAccountInfo() {
		return ResponseEntity.ok(accountConfigProperties.getMessage());
	}

}
