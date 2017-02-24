package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;

import java.io.File;

public class DatabaseGenerator {

   /**
    * Exporting DAO objects and Entities to /retrofitdemo/db/
    * @param args
    */
    public static void main(String [] args)
    {
        Schema schema = new Schema(1, "com.retrofit.android.retrofitdemo.db");
        schema.enableKeepSectionsByDefault();
        addTables(schema);

        try {
            File outputDir =
                    new File("./app/src/main/java/com/retrofit/android/retrofitdemo/db");
            outputDir.mkdirs();

            new DaoGenerator()
                    .generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addUserEntities(schema);

        Entity other = addOther(schema);
        Entity planDetail = addPlanDetail(schema, other);
        Entity line = addLine(schema, planDetail);
        addPhoneAllLines(schema, line);
    }

    private static Entity addUserEntities(final Schema schema) {
        Entity user = schema.addEntity("User");
        user.addIdProperty().primaryKey().autoincrement();
        user.addIntProperty("user_id").notNull();
        user.addStringProperty("last_name");
        user.addStringProperty("first_name");
        user.addStringProperty("email");
        return user;
    }

    private static Entity addLine(final Schema schema, Entity planDetail) {
        Entity line = schema.addEntity("Line");
        line.addIdProperty().primaryKey().autoincrement();
        line.addStringProperty("lineId").notNull();
        line.addLongProperty("number");
        line.addLongProperty("planId");
        line.addStringProperty("planName");
        line.addStringProperty("owner");
        line.addBooleanProperty("mainLine");

        Property property = planDetail.getProperties().get(0);
        line.addToOneWithoutProperty("planDetail", planDetail,"id");

        return line;
    }

    private static Entity addPlanDetail(final Schema schema, Entity other) {
        Entity planDetail = schema.addEntity("PlainDetail");
        planDetail.addIdProperty().primaryKey().autoincrement();
        planDetail.addLongProperty("remainMinutes");
        planDetail.addLongProperty("remainSms");
        planDetail.addLongProperty("remainInternet");

        Property property = other.getProperties().get(0);
        ToMany toMany = planDetail.addToMany(other, property, "other");

        return planDetail;
    }

    private static Entity addOther(final Schema schema)
    {
        Entity user = schema.addEntity("Other");
        user.addIdProperty().primaryKey().autoincrement();
        user.addStringProperty("item");
        return user;
    }

    private static Entity addPhoneAllLines(final Schema schema, Entity line)
    {
        Entity phoneAllLines = schema.addEntity("PhoneAllLines");
        phoneAllLines.addIdProperty().primaryKey().autoincrement();

        Property property = line.getProperties().get(0);
        phoneAllLines.addToMany(line, property, "lines");
        return phoneAllLines;
    }
}
