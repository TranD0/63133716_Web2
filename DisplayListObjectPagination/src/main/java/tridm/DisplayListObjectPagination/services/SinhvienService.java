package tridm.DisplayListObjectPagination.services;

import org.springframework.stereotype.Service;
import tridm.DisplayListObjectPagination.models.SinhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@Service
public interface SinhvienService {
	public Page<SinhVien> findPaginated(Pageable pageable);
     
   
}