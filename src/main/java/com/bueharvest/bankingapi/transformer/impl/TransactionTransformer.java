package com.bueharvest.bankingapi.transformer.impl;

import com.bueharvest.bankingapi.domain.Transaction;
import com.bueharvest.bankingapi.transformer.ITransactionTransformer;

public class TransactionTransformer implements ITransactionTransformer {

    public Transaction toDTO(com.bueharvest.bankingapi.model.Transaction transaction) {
        Transaction dto = new Transaction();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        return dto;
    }

    public com.bueharvest.bankingapi.model.Transaction toModel(Transaction dto) {
        com.bueharvest.bankingapi.model.Transaction transaction = new com.bueharvest.bankingapi.model.Transaction();
        transaction.setId(dto.getId());
        transaction.setAmount(dto.getAmount());
        return transaction;
    }
}
