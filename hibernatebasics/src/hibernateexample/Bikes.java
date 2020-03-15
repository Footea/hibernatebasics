package hibernateexample;

/**
 * Aaron Foote
 */

import javax.persistence.*;


@Entity
@Table(name = "bikes")
public class Bikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "bike_id")
    private int bike_id;

    @Column( name = "bike_maker")
    private String bike_maker;

    @Column( name = "bike_model")
    private String bike_model;

    @Column(name = "bike_use")
    private String bike_use;

    @Column( name = "bike_type")
    private String bike_type;

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public String getBike_maker() {
        return bike_maker;
    }

    public void setBike_maker(String bike_maker) {
        this.bike_maker = bike_maker;
    }

    public String getBike_model() {
        return bike_model;
    }

    public void setBike_model(String bike_model) {
        this.bike_model = bike_model;
    }

    public String getBike_use() {
        return bike_use;
    }

    public void setBike_use(String bike_use) {
        this.bike_use = bike_use;
    }

    public String getBike_type() {
        return bike_type;
    }

    public void setBike_type(String bike_type) {
        this.bike_type = bike_type;
    }


    @Override
    public String toString() {
        return Integer.toString(bike_id) +
                //       "bike_id=" + bike_id +
                " " + bike_maker +
                " " + bike_model +
                " " + bike_use +
                " " + bike_type;
    }
}//end Bikes class
