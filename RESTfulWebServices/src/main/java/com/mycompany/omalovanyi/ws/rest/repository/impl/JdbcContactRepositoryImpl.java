package com.mycompany.omalovanyi.ws.rest.repository.impl;

import com.mycompany.omalovanyi.ws.rest.model.Contact;
import com.mycompany.omalovanyi.ws.rest.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Repository
public class JdbcContactRepositoryImpl implements ContactRepository {

    private static final String SQLQUERY = "select * from contacts";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> findByNameFilter(String nameFilter) {

        return jdbcTemplate.query(SQLQUERY, new ResultSetExtractor<List>() {

            public List extractData(ResultSet rs) throws SQLException, DataAccessException {

                List<Contact> contactList = new ArrayList<>();
                Pattern pattern = Pattern.compile(nameFilter);
                Matcher matcher = null;
                String name = null;
                Contact contact = null;

                while (rs.next()) {
                    name = rs.getString("name");
                    matcher = pattern.matcher(name);
                    if (!matcher.matches()) {
                        contact = new Contact(rs.getLong("id"), name);
                        contactList.add(contact);
                    }
                }
                return contactList;
            }
        });
    }

    @Override
    public List<Contact> getAll() {
        return jdbcTemplate.query(SQLQUERY, new BeanPropertyRowMapper(Contact.class));
    }
}
