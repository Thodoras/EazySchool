package org.thodoras.eazyschool.api.html.dtos.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.thodoras.eazyschool.domain.ContactDomain;

@Data
public class AddContactRequestDto {

    @NotBlank(message = "Name must not be blank.")
    @Size(min=3, message = "Name must be at least 3 characters lomg.")
    private String name;

    @NotBlank(message="Mobile number must not be blank.")
    @Pattern(regexp = "(^$|[0-9]{10})", message="Mobile number should be 10 digits.")
    private String mobileNum;

    @NotBlank(message = "Email must not be blank.")
    @Email(message = "Please provide a valid email.")
    private String email;

    @NotBlank(message = "Subject should not be blank.")
    @Size(min=5, message = "Subject should be at least 5 characters long.")
    private String subject;

    @NotBlank(message = "Message must not be blank.")
    @Size(min = 10, message = "Subject must be at least 10 characters long.")
    private String message;

    public ContactDomain toDomain() {
        var result = new ContactDomain();
        result.setName(getName());
        result.setMobileNum(getMobileNum());
        result.setEmail(getEmail());
        result.setSubject(getSubject());
        result.setMessage(getMessage());
        return result;
    }
}
