package LPH.StoreManagement.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 15)
    private String phone;

    @Lob
    private String address;

  
    @Column(nullable = false, length = 10)
    private String role;

    @Column(name = "status")
    private String status;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

  
    
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    

  
}
