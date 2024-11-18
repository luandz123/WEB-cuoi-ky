package LPH.StoreManagement.Service;

import java.util.List;

import LPH.StoreManagement.Model.TonKho;

public interface TonKhoService {
    TonKho createTonKho(TonKho tonKho);
    List<TonKho> getAllTonKho();
    TonKho getTonKhoById(Long id);
    TonKho updateTonKho(Long id, TonKho tonKhoDetails);
    void deleteTonKho(Long id);
    

}
