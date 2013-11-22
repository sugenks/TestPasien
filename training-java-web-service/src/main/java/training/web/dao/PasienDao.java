/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.web.dao;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import training.web.domain.Pasien;


/**
 *
 * @author admin
 */
public interface PasienDao extends PagingAndSortingRepository<Pasien, String> {

    @Query("select p from Pasien p "
            + "where p.norm = :norm ")
    public Page<Pasien> cariByNorm(
            @Param("norm") String norm, Pageable pageable);

    public Page<Pasien> findByTanggalBetween(
            Date start, Date end, Pageable pageable);

//    public Long countPasienByTanggal(Date start, Date end);

 //   public Pasien findOne(Pasien pasien);

//    public Pasien findOne(Pasien pasien);
    
    
}
