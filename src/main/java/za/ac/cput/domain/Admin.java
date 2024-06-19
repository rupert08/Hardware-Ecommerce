package za.ac.cput.domain;

import jakarta.persistence.*;


@Entity
public class Admin extends User{

    protected Admin() {
    }

    public Admin (Builder builder) {
       // this.userId = builder.userId;
        this.username = builder.username;
        this.password = builder.password;
        this.role = builder.role;
        this.contact = builder.contact;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private long userId;
        private String username;
        private String password;
        private String role;
        private Contact contact;

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

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy (Admin admin) {
            this.userId = admin.userId;
            this.username = admin.username;
            this.password = admin.password;
            this.role = admin.role;
            this.contact = admin.contact;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}

