package ru.app.sixth.service;

import java.util.List;

public interface CrudOptions<T> {

    /**
     * Создать новый объект
     * @param entity
     * @return
     */
    T create(T entity);

    /**
     * Получить объект по ID
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * Получить все объекты
     * @return
     */
    List<T> getAll();

    /**
     * Обновить объект
     * @param entity
     * @return
     */
    T update(T entity);

    /**
     * Удалить объект по ID
     * @param id
     * @return
     */
    T deleteById(Long id);
}