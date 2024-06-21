package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.service.AdminService;

import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Admin create (@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    @GetMapping("/read/{userId}")
    public Admin read(@PathVariable Long userId) {
        return adminService.read(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId) {
        adminService.delete(userId);
    }

    @GetMapping("/getAll")
    public Set<Admin> getAll() {
        return adminService.getAll();
    }
}
