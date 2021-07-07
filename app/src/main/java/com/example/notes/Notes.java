    package com.example.notes;

    import android.os.Parcel;
    import android.os.Parcelable;

    import java.util.Date;

    public class Notes implements Parcelable {

        private String date;
        private String name;
        private String description;

        public Notes ( String date, String name, String description){
            this.setDate(date);
            this.setName(name);
            this.setDescription(description);
        }

         protected Notes(Parcel in) {
            date = in.readString();
            name = in.readString();
            description = in.readString();
        }

        public static final Creator<Notes> CREATOR = new Creator<Notes>() {
            @Override
            public Notes createFromParcel(Parcel in) {
                return new Notes(in);
            }

            @Override
            public Notes[] newArray(int size) {
                return new Notes[size];
            }
        };

        public Notes() {
            this.date = "";
            this.name = "";
            this.description = "12";
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(getDate());
            dest.writeString(getName());
            dest.writeString(getDescription());
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
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
