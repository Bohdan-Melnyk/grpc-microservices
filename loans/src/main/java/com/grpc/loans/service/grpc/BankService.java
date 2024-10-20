package com.grpc.loans.service.grpc;

import com.bank.Bank;
import com.bank.LoansServiceGrpc;
import com.grpc.loans.mapper.LoansMapper;
import com.grpc.loans.repository.LoansRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
@RequiredArgsConstructor
public class BankService extends LoansServiceGrpc.LoansServiceImplBase {

    private final Logger logger = LoggerFactory.getLogger(BankService.class);

    private final LoansRepository loansRepository;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void fetchLoanDetailsProto(Bank.StringValue request, StreamObserver<Bank.LoanDto> responseObserver) {
        logger.info(request.getValue());
        loansRepository.findByLoanNumber(request.getValue())
                .map(LoansMapper::mapToLoansDtoProto)
                .ifPresentOrElse(responseObserver::onNext, () -> System.out.println("Not found"));
        responseObserver.onCompleted();
    }
}