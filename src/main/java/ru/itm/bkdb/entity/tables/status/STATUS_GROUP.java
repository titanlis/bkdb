package ru.itm.bkdb.entity.tables.status;

public enum STATUS_GROUP {
	LU_WORK,//овцеводство
	LOADING_WORK, //погрузка
	
	UNLOADED,//порожний
	UNLOADING_WORK, //разгрузка
	
	LOADED,//груженый
	STOPMOVE,//статус на остановку движения
	
	REFUELING_WORK,//перезаправка
	DRILLING_WORK, //бурение
	NAVIGATION_DRILL, //навигация буровой
	MOVING, //движение
	DOZER_WORK, //работа дозера
	ROUTING, //
	ALIGNMENT_DRILL, //выравнивание перед бурением
	MOVE_DRILL, //перегон буровой
	STEERING_DRILL, //наведение буровой
	
	INTERACTION_LOADING,//установление связи с погрузчиком
	INTERACTION_FUELING,//установление связи с заправщиком		
	LOADING_QUEUE, //очередь погрузки
	MOVING_TO_FUELING, //движение на заправку
	
	ACCEPT_TO_INTERACTION,
	
	WORKING,
	DOWNTIME,
	CRASH,
	REPAIR,
	RESERVE,
}
