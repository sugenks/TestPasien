/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function createGridPasien() {

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
            field: 'alamat_ktp',
            title: 'Alamat',
            width: 110
        },
        {
            field: 'telp',
            title: 'Telp',
            width: 110
        },
        {
            field: 'sex',
            title: 'Kelamin',
            width: 110
        },
        {
            field: 'tgl_lahir',
            title: 'Tgl Lahir',
            width: 110
        },
        {
            field: 'tanggal',
            title: 'Tanggal',
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

