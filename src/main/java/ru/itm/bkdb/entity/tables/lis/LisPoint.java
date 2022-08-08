package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_point", schema = "lis")
public class LisPoint extends AbstractEntity {
	private double x;
	private double y;
	private int number_point;
	private Long connection_id_fk;

	public LisPoint() {}

	@Override
	public String toString() {
		return "lis.lis_point{" +
				"id=" + id +
				", x=" + x +
				", y=" + y +
				", number_point=" + number_point +
				", connection_id_fk=" + connection_id_fk +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getNumber_point() {
		return number_point;
	}

	public void setNumber_point(int number_point) {
		this.number_point = number_point;
	}

	public Long getConnection_id_fk() {
		return connection_id_fk;
	}

	public void setConnection_id_fk(Long connection_id_fk) {
		this.connection_id_fk = connection_id_fk;
	}
}
