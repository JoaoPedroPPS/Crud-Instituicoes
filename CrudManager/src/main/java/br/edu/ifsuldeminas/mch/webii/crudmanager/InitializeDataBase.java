package br.edu.ifsuldeminas.mch.webii.crudmanager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.InstitutionRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.*;
@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
    
    @Autowired
    private InstitutionRepository institutionRepository;
    
    @Override
    public void run(String... args) throws Exception {
    	Institution ifMachado = new Institution();
        ifMachado.setName("IF Suldeminas Machado");
        ifMachado.setAddress("Rua Sao Joaquim, 250");
        ifMachado.setPhone(32952929);
        
        
        Institution cefsmac = new Institution();
        cefsmac.setName("Centro de Formação Superior Machadense");
        cefsmac.setAddress("Rua Dom Roberto, 1952");
        cefsmac.setPhone(32955555);
        
        Institution astra = new Institution();
        astra.setName("Astra - Ensino Superior");
        astra.setAddress("Rua Dom Roberto, 1115");
        astra.setPhone(32951782);
        
        institutionRepository.save(ifMachado);
        institutionRepository.save(cefsmac);
        institutionRepository.save(astra);
     }
    
}