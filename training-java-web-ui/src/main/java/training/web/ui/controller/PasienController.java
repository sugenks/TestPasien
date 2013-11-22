/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.web.ui.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import training.web.service.BelajarService;

/**
 *
 * @author admin
 */
public class PasienController {

    @Autowired
    private BelajarService service;

    @RequestMapping(value = "/pasien/list", method = RequestMethod.GET)
    public ModelMap viewFormPasien() {
        return new ModelMap();
    }

    @ResponseBody
    @RequestMapping(value = "/pasien/json", method = RequestMethod.GET)
    public Map<String, Object> getJsonPasien(Pageable pageable) {
        Map<String, Object> result
                = new HashMap<String, Object>();
//        result.put("total", service.countPasien());
        result.put("rows", service.findAllPasien(pageable).getContent());
        return result;
    }

//    @RequestMapping(value = "/barang/print",
//            method = RequestMethod.GET)
//    public ModelMap cetakDaftarBarang() {
//
//        Long countPasien = service.countPasien();
//        PageRequest pr = new PageRequest(0, countPasien.intValue());
//
//        ModelMap mm = new ModelMap();
//        mm.put("format", "pdf");
//        mm.put("tanggalCetak", new Date());
//        mm.put("listBarang", service.findAllPasien(pr).getContent());
//        return mm;
//    }

}
