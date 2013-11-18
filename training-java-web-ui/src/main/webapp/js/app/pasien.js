/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function createGridBarang() {

    $('#gridPasien').datagrid({
        style: 'width:700px; height:200px',
        method: 'get',
        url: 'json',
        idField: 'norm',
        fitColumns: 'true',
        nowrap: false,
        singleSelect: true,
        pagination: true,
        rownumbers: true,
        pageSize: 10,
        queryParams: {
            'page.page':1,
            'page.size':10
//            'startDate':new Date() //untuk kirim parameter ke server
        },
        columns: [[
        {
            field: 'norm',
            title: 'NORM',
            width: 110
        },
        {
            field: 'nama',
            title: 'Nama Pasien',
            width: 110
        },
        {
            field: 'no_ktp',
            title: 'No KTP',
            width: 110
        },
        {
            field: 'alamat_ktp',
            title: 'Alamat',
            width: 110
        },
        {
            field: 'kode_kota_ktp',
            title: 'Kode Kota',
            width: 110
        },
        {
            field: 'sex',
            title: 'Kelamin',
            width: 110
        },
        {
            field: 'kode_kota_lahir',
            title: 'Kd Kota Lahir',
            width: 110
        },
        {
            field: 'tgl_lashir',
            title: 'Tgl Lahir',
            width: 110
        },
        {
            field: 'usia_th',
            title: 'usia_th',
            width: 110
        }
        ]],
        onLoadSuccess:function(row,data){
            var pager = $('#gridPasien').datagrid('getPager');
            pager.pagination({
                onSelectPage: function(pageNumber, pageSize){
                    $.ajax({
                        type:"GET",
                        url: 'json',
                        data: {
                            'page.page':pageNumber,
                            'page.size':pageSize
                            //'startDate':new Date() //untuk kirim parameter ke server
                        },
                        dataType:'json',
                        beforeSend: function(jqXHR, settings){
                            $('#gridPasien').datagrid('loading');
                        },
                        success: function(data){
                            $('#gridPasien').datagrid('loadData',data);
                        },
                        complete: function(jqXHR, textStatus){
                            $('#gridPasien').datagrid('loaded');
                        }
                    });
                }
            });
        },
        onLoadError: function(error) {
            console.log("error loading grid data " + error);
        }
    });
    
}

