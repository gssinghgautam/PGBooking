package com.app.pgbooking.ui.pgrooms.model;

import java.util.List;

/**
 * Created by gautam on 26/03/18.
 */

public class PgDataSet {

    private final List<PgData> pgDataList;

    public PgDataSet(List<PgData> pgDataList) {
        this.pgDataList = pgDataList;
    }

    public int size() {
        return pgDataList.size();
    }

    public PgData getPgData(int position) {
        return pgDataList.get(position);
    }

    public void addPgData(PgData message) {
        this.pgDataList.add(message);
    }

    public int addPgDataList(List<PgData> pgDataList) {
        int count;
        for (count = 0; count < pgDataList.size() - 1; count++)
            this.pgDataList.add(count, pgDataList.get(count));
        return count;
    }

    public List<PgData> getPgDataList() {
        return pgDataList;
    }

    /*public PgDataSet sortedByDate() {
        List<PgData> sortedList = new ArrayList<>(messages);
        Collections.sort(sortedList, byDate());
        return new PgDataSet(sortedList);
    }

    private static Comparator<? super PgData> byDate() {
        return new Comparator<PgData>() {
            @Override
            public int compare(PgData o1, PgData o2) {
                long time1 = Long.parseLong(o1.getTimestamp().replace("/", ""));
                long time2 = Long.parseLong(o2.getTimestamp().replace("/", ""));
                return time1 < time2 ? -1 : time1 > time2 ? 1 : 0;
            }
        };
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PgDataSet pgDataSet = (PgDataSet) o;

        return pgDataList != null ? pgDataList.equals(pgDataSet.pgDataList) : pgDataSet.pgDataList == null;

    }

    @Override
    public int hashCode() {
        return pgDataList != null ? pgDataList.hashCode() : 0;
    }
}
