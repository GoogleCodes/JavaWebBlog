// pages/me.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nickName: '',
    avatarUrl: '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    let that = this;
    wx.getUserInfo({
      success(res) {
        var userInfo = res.userInfo,
            nickName = userInfo.nickName,
            avatarUrl = userInfo.avatarUrl,
            gender = userInfo.gender,
            province = userInfo.province,
            city = userInfo.city,
            country = userInfo.country;

        that.setData({
          nickName: nickName,
          avatarUrl: avatarUrl
        });


        console.log(that.data.nickName, that.data.avatarUrl);

      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})