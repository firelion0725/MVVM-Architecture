package com.leo.test.data.dao.load;

import java.util.List;

/**
 * @author leo, ZhangWei
 * @date 2018/9/5
 * @function
 */
public class CategoriesDao {

    private Boolean error;
    private List<CategoriesData> results;

    public static class CategoriesData {
        private String _id;
        private String en_name;
        private String name;
        private Integer rank;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getEn_name() {
            return en_name;
        }

        public void setEn_name(String en_name) {
            this.en_name = en_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "CategoriesData{" +
                    "_id='" + _id + '\'' +
                    ", en_name='" + en_name + '\'' +
                    ", name='" + name + '\'' +
                    ", rank=" + rank +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CategoriesDao{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
