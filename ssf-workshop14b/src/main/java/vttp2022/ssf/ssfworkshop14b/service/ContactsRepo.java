package vttp2022.ssf.ssfworkshop14b.service;

import vttp2022.ssf.ssfworkshop14b.model.Contact;

public interface ContactsRepo {
    public void save(final Contact contact);

    public Contact findById(final String contactId);

}
