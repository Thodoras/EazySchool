package org.thodoras.eazyschool.repositories.db.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.thodoras.eazyschool.domain.ContactDomain;
import org.thodoras.eazyschool.helpers.aspects.interfaces.LogExceptionAspect;
import org.thodoras.eazyschool.repositories.db.models.ContactModel;
import org.thodoras.eazyschool.interfaces.IContactsRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContactRepository implements IContactsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ContactDomain> getcontacts(String status) {
        var sql = "SELECT * FROM contacts WHERE status = ?";
        var results = jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status);
            }
        }, new ContactModelRowMapper());
        return ContactModel.toDomains(results);
    }

    @Override
    public ContactDomain addContact(ContactDomain contactDomain) {
        var model = new ContactModel(contactDomain);
        var sql = "INSERT INTO contacts" +
                "(name, mobile_num, email, subject, message, status, created_at, updated_at)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        var contactId = jdbcTemplate.update(
                sql,
                model.getName(),
                model.getMobileNum(),
                model.getEmail(),
                model.getSubject(),
                model.getMessage(),
                model.getStatus().toString(),
                model.getCreatedAt(),
                model.getUpdatedAt()
        );
        model.setId(contactId);
        return model.toDomain();
    }

    public int updateStatus(int id, ContactDomain.Status status) {
        var sql = "UPDATE contacts SET status = ?, UPDATED_AT = ? WHERE CONTACT_ID = ?";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status.toString());
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(3, id);
            }
        });
    }

    private class ContactModelRowMapper implements RowMapper<ContactModel> {

        public ContactModelRowMapper() {}
        @Override
        public ContactModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            var contact = new ContactModel();
            contact.setId(rs.getInt("contact_id"));
            contact.setName(rs.getNString("name"));
            contact.setMobileNum(rs.getString("mobile_num"));
            contact.setEmail(rs.getString("email"));
            contact.setSubject(rs.getString("subject"));
            contact.setMessage(rs.getString("message"));
            contact.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            contact.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            return contact;
        }
    }
}
