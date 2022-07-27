package com.example.demoanalytic;


public class TimeEntity {
    public String name;
    public Timming2 timming;
    public int btn;


    public TimeEntity(String name, Timming2 timming, int btn) {
        this.name = name;
        this.timming = timming;
        this.btn = btn;
    }

    public class Timming2 {

        public String id;
        public String equipmentId;//:"zcz001100112", 注意:网关下面传设备 如:2819189_C1C0形式
        public String productId;//:"zcz001", 注意:网关下面产品 统一为GWD001
        public String userId;//:"minApp108881",
        public String countDownTime;//:"13:02",
        public int executeSwitch;//:1,
        public int btn;//:1 默认是1 可以不传
        public String createTime;//创建时间2022-02-14 14:50:43
        public long serverTime;//创建时间2022-02-14 14:50:43
        public Timming2(String id, String equipmentId, String productId, String userId, String countDownTime, int executeSwitch, int btn, String createTime, long serverTime) {
            this.id = id;
            this.equipmentId = equipmentId;
            this.productId = productId;
            this.userId = userId;
            this.countDownTime = countDownTime;
            this.executeSwitch = executeSwitch;
            this.btn = btn;
            this.createTime = createTime;
            this.serverTime = serverTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(String equipmentId) {
            this.equipmentId = equipmentId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCountDownTime() {
            return countDownTime;
        }

        public void setCountDownTime(String countDownTime) {
            this.countDownTime = countDownTime;
        }

        public int getExecuteSwitch() {
            return executeSwitch;
        }

        public void setExecuteSwitch(int executeSwitch) {
            this.executeSwitch = executeSwitch;
        }

        public int getBtn() {
            return btn;
        }

        public void setBtn(int btn) {
            this.btn = btn;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public long getServerTime() {
            return serverTime;
        }

        public void setServerTime(long serverTime) {
            this.serverTime = serverTime;
        }
    }
}
