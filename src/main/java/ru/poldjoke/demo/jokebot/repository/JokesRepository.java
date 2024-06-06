package ru.poldjoke.demo.jokebot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.poldjoke.demo.jokebot.model.Joke;

public interface JokesRepository extends JpaRepository<Joke, Long> {

    @Query("SELECT j FROM Jokes j ORDER BY RANDOM() LIMIT 1") // LIMIT 1, чтобы получить только одну запись
    Joke findRandomJoke();

    // Пагинация для получения всех шуток
    Page<Joke> findAll(Pageable pageable);

    // Пагинация для топ-5 по популярности (сортируем по количеству JokeVisitor)
    Page<Joke> findByOrderByJokeVisitorDesc(Pageable pageable);
}
