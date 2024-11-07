package ra.com.service.imp;

import ra.com.entity.Categories;
import ra.com.reposistory.CategoriesRepository;
import ra.com.reposistory.imp.CategoriesRepositoryImp;
import ra.com.service.CategoriesService;

import java.util.List;

public class CategoriesServiceImp implements CategoriesService {
    //tiêm vào 1 instace của CategoriesRepository
    private CategoriesRepository categoriesRepository;

    public CategoriesServiceImp() {
        categoriesRepository = new CategoriesRepositoryImp();
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }
}
