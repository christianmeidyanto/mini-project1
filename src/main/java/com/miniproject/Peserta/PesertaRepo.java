package com.miniproject.Peserta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesertaRepo extends CrudRepository<Peserta, String> {

    // Find uniquecode peserta
    @Query("SELECT p FROM Peserta p WHERE p.uniquecode =:uniquecode")
    Peserta findPesertaByUniqueCode(String uniquecode);

}
