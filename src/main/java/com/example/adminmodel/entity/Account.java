package com.example.adminmodel.entity;

import com.example.adminmodel.entity.base.BaseEntity;
import com.example.adminmodel.entity.entityEnum.AccountStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Account extends BaseEntity {
    private int id;
    private String usename;
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;
    private int roleId;
    private AccountStatus status;



    public Account() {
        this.email = "";
        this.usename = "";
        this.fullName = "";
        this.status = AccountStatus.ACTIVE;
    }
    public Account(int id, String username, String password, String fullName, AccountStatus status) {
        this.id = id;
        this.usename = username;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + usename + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", status=" + status + '\'' +
                ", createdAt=" + getCreatedAt() + '\'' +
                ", updatedAt=" + getUpdatedAt() + '\'' +
                ", createdBy=" + getCreatedBy() + '\'' +
                ", updatedBy=" + getUpdatedBy() + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (usename == null || usename.length() == 0) {
            errors.put("username", "Please enter username.");
        }
        if (password == null || password.length() == 0) {
            errors.put("password", "Please enter password.");
        }
        if (password != null && password.length() > 0
                && !password.equals(confirmPassword)) {
            errors.put("confirmPassword", "Confirm password is not match.");
        }
        if (fullName == null || fullName.length() == 0) {
            errors.put("fullName", "Please enter full name.");
        }
        if (email == null || email.length() == 0) {
            errors.put("email", "Please enter email.");
        }
        if(email != null && email.length() > 0 && !StringValidationHelper.checkValidEmail(email)){
            errors.put("email", "Invalid email.");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public static final class AccountBuilder {
        private int id;
        private String username;
        private String email;
        private String password;
        private String confirmPassword;
        private String fullName;
        private AccountStatus status; // 1. active, -1. deleted, 0. deactive
        private HashMap<String, String> errors = new HashMap<>();
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime deletedAt;
        private int createdBy;
        private int updatedBy;
        private int deleteBy;

        private AccountBuilder() {
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public AccountBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder withConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public AccountBuilder withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public AccountBuilder withStatus(AccountStatus status) {
            this.status = status;
            return this;
        }

        public AccountBuilder withErrors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public AccountBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public AccountBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public AccountBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccountBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public AccountBuilder withDeleteBy(int deleteBy) {
            this.deleteBy = deleteBy;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setId(id);
            account.setUsename(username);
            account.setEmail(email);
            account.setPassword(password);
            account.setConfirmPassword(confirmPassword);
            account.setFullName(fullName);
            account.setStatus(status);
            account.setErrors(errors);
            account.setCreatedAt(createdAt);
            account.setUpdatedAt(updatedAt);
            account.setDeletedAt(deletedAt);
            account.setCreatedBy(createdBy);
            account.setUpdatedBy(updatedBy);
            account.setDeleteBy(deleteBy);
            return account;
        }
    }
}
