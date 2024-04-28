package org.thodoras.eazyschool.repositories.db.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.thodoras.eazyschool.domain.HolidayDomain;
import org.thodoras.eazyschool.interfaces.IHolidayRepository;
import org.thodoras.eazyschool.repositories.db.models.HolidayModel;

import java.util.List;

@Repository
public class HolidayRepository implements IHolidayRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidayRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<HolidayDomain> list() {
        var sql = "SELECT * FROM holidays";
        var rowMapper = BeanPropertyRowMapper.newInstance(HolidayModel.class);
        var models = jdbcTemplate.query(sql, rowMapper);
        return HolidayModel.toDomains(models);
    }
}
