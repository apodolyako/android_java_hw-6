    package com.example.notes;

    import android.os.Parcel;
    import android.os.Parcelable;

    import java.util.Date;

    public class Notes implements Parcelable {

        private Date date;
        private String name;
        private String description;

        public Notes (Date date, String name, String description){
            this.setDate(date);
            this.setName(name);
            this.setDescription(description);
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
