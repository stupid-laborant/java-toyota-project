package com.company.factory;

import com.company.cars.components.*;

public class Factory {

/*    Задание №2
    Мы с вами создали машины, их детали, описали действия. Но создавать машины сейчас крайне неудобно: нам приходиться самим создавать детали, передавать их в конструктор. А ведь менеджеру нужно только установить цену машины и ее цвет!
    Необходимо:
            1. Реализовать фабрику производств деталей - класс, в котором будут методы создающие все наши детали в работоспособном состоянии, (бензобак должен быть пустой).
            У завода должнен быть атрибут - страна( ведь заводов может быть много). Подумать, какой тип данных у атрибута Страна.
            2. Реализовать сборочный конвеер - класс, который будет использовать фабрику производств и отдавать нам готовые машины.
            Например должен быть метод, который принимает в себя два параметра - цвет и цену, а возвращает новую Camry.
            Необходимо создать 4 метода, которые будут создавать все наши модели: createCamry, createSolara, createHiance, createDyna.
            Сборочный конвеер может пользоваться только той фабрикой производств, которая находится в той же стране (Подумать где должна происходить эта проверка).
            Иначе должна появляться ошибка: CountyFactoryNotEqualException - в описании ошибки должны описаться страны которые не совпали.

            ОПЦИОНАЛЬНО (не будет разбираться, на развитие)
            1. Создать абстрактную фабрику, которая будет создавать типовые детали для машины. Создать 4 реализации этой фабрики, под каждую конкретную модель
2. Отрефакторить код так, чтобы можно было сделать фабрику через Generics (передали цвет, цену, класс машины, получили новый экзмпляр переданного класса)*/
    private final Country country;

    public Country getCountry() {
        return country;
    }

    public Factory(Country country) {
        this.country = country;
    }

    Electrics createElectrics() {
        return new Electrics();
    }

    Engine createEngine() {
        return new Engine();
    }

    Headlight createHeadlight() {
        return new Headlight();
    }

    Tank createTank() {
        return new Tank();
    }

    Wheel createWheel(WheelSize wheelSize) {
        return new Wheel(wheelSize);
    }
}
