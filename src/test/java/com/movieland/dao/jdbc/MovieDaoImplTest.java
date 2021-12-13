package com.movieland.dao.jdbc;

import com.movieland.dao.MovieDao;
import com.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.movieland.entity.Movie;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MovieDaoImplTest extends TestCase {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private String getMovieByIdSQL;
//
//    @Autowired
//    private String addMovieSQL;
//
//    @Autowired
//    private String getRandomMovieSQL;

    @Before
    public void Init(){
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setMovieNameRu("MyMovie");
        when(jdbcTemplate.queryForObject(any(), new Object[]{any()}, any(MovieRowMapper.class))).thenReturn(movie);
    }

    @Test
    public void testMovieDaoImpl(){
        MovieDao movieDao = new MovieDaoImpl();
        Movie movie = movieDao.getById(1);
        System.out.println(movie);

    }

}