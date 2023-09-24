package com.blueharvest.bankingapi.transformer;

import com.blueharvest.bankingapi.domain.Transaction;

public interface ITransactionTransformer {

    public Transaction toDTO(com.blueharvest.bankingapi.model.Transaction transaction);

    public com.blueharvest.bankingapi.model.Transaction toModel(Transaction dto);
}
