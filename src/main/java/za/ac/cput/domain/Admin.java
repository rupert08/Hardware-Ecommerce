package za.ac.cput.domain;

import jakarta.persistence.*;


@Entity
public class Admin extends User{
    protected Admin() {
    }

    public Admin (Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.password = builder.password;
        this.role = builder.role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static class Builder {
        private long userId;
        private String username;
        private String password;
        private String role;

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder copy (Admin admin) {
            this.userId = admin.userId;
            this.username = admin.username;
            this.password = admin.password;
            this.role = admin.role;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}

