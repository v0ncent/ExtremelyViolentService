package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.POJOModels.AdminEmailModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.AdminRepository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public final class AdminController extends APIRoute<AdminEmailModel> {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public MongoRepository<AdminEmailModel, Long> getRepository() {
        return adminRepository;
    }
}
