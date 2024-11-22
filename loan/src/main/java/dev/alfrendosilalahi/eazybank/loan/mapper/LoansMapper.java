package dev.alfrendosilalahi.eazybank.loan.mapper;

import dev.alfrendosilalahi.eazybank.loan.dto.LoansDto;
import dev.alfrendosilalahi.eazybank.loan.entity.Loan;

public class LoansMapper {

    public static LoansDto mapToLoansDto(Loan loan, LoansDto loansDto) {
        loansDto.setLoanNumber(loan.getLoanNumber());
        loansDto.setLoanType(loan.getLoanType());
        loansDto.setMobileNumber(loan.getMobileNumber());
        loansDto.setTotalLoan(loan.getTotalLoan());
        loansDto.setAmountPaid(loan.getAmountPaid());
        loansDto.setOutstandingAmount(loan.getOutstandingAmount());
        return loansDto;
    }

    public static Loan mapToLoans(LoansDto loansDto, Loan loan) {
        loan.setLoanNumber(loansDto.getLoanNumber());
        loan.setLoanType(loansDto.getLoanType());
        loan.setMobileNumber(loansDto.getMobileNumber());
        loan.setTotalLoan(loansDto.getTotalLoan());
        loan.setAmountPaid(loansDto.getAmountPaid());
        loan.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loan;
    }

}
