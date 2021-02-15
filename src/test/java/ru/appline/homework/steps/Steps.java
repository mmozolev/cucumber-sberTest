package ru.appline.homework.steps;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.appline.homework.managers.PageManager;

public class Steps {

    private PageManager app = PageManager.getPageManager();

    @Когда("^Загружена стартовая страница$")
    public void initPage(){
        app.getStartPage();
    }

    @Тогда("^Переход в главное меню '(.*)'$")
    public void selectMenu(String nameMenu){
        app.getStartPage().selectMenu(nameMenu);
    }

    @Тогда("^Выбор подменю '(.*)'$")
    public void selectSubMenu(String nameSubMenu){
        app.getStartPage().selectSubMenu(nameSubMenu);
    }

    @Когда("^Заполняем форму поле/значение$")
    public void fillFields(DataTable dataTable){
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().changeValue((raw.get(0)), raw.get(1));
                }
        );
    }

    @Когда("^Установить дополнительную опцию$")
    public void changeOptions(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().switchOption((raw.get(0)), (raw.get(1)));
                }
        );
    }

    @Когда("^Проверить поля и их значения$")
    public void checkFields(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().checkField((raw.get(0)), (raw.get(1)));
                }
        );
    }


}