package com.bueharvest.bankingapi.transformer;

import com.bueharvest.bankingapi.domain.Transaction;

public interface ITransactionTransformer {

    public Transaction toDTO(com.bueharvest.bankingapi.model.Transaction transaction);

    public com.bueharvest.bankingapi.model.Transaction toModel(Transaction dto);
}
