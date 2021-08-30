package com.gb.sudar.homework6.services;

import com.gb.sudar.homework6.model.Client;
import com.gb.sudar.homework6.repository.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {
    private ClientDao clientDao;

    @Autowired

    public ClientsService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public Client findById(Long id) {
        return clientDao.findById(id);
    }

    public void save(Client client) {
        clientDao.save(client);
    }


}
