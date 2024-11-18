package dev.alfrendosilalahi.eazybank.account.controller;

import dev.alfrendosilalahi.eazybank.account.config.properties.AccountConfigProperties;
import dev.alfrendosilalahi.eazybank.account.dto.request.CustomerRequestDto;
import dev.alfrendosilalahi.eazybank.account.dto.request.UpdateAccountRequestDto;
import dev.alfrendosilalahi.eazybank.account.dto.response.AccountResponseDto;
import dev.alfrendosilalahi.eazybank.account.dto.response.ErrorBaseResponseDto;
import dev.alfrendosilalahi.eazybank.account.dto.response.SuccessBaseResponseDto;
import dev.alfrendosilalahi.eazybank.account.service.AccountService;
import dev.alfrendosilalahi.eazybank.account.utils.ResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
	name = "Account API endpoints for Eazy Bank Account Microservice", 
	description = "Account API endpoints for Eazy Bank Account Microservice"
)
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

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

	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildVersion() {
		return ResponseEntity.ok(buildVersion);
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
