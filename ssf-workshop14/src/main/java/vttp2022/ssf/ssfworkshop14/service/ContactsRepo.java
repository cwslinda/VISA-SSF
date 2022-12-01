package vttp2022.ssf.ssfworkshop14.service;


import org.springframework.stereotype.Repository;

import vttp2022.ssf.ssfworkshop14.model.Contact;

@Repository
public interface ContactsRepo{
    public void save(final Contact ctc);

    public Contact findById(final String contactId);
}