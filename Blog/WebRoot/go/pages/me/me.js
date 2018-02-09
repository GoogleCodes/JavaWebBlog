// pages/me.js

import { Main } from '../../utils/util.js'
let $ = new Main();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    nickName: '',
    avatarUrl: '',
    lastX: 0,     //滑动开始x轴位置
    lastY: 0,     //滑动开始y轴位置
    currentGesture: 0, //标识手势
    status: false,
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
      }
    })
  },

  handletouchmove(e) {
    let that = this;
    var currentX = e.touches[0].pageX;
    var currentY = e.touches[0].pageY;
    var tx = currentX - this.data.lastX;
    var ty = currentY - this.data.lastY;
    //左右方向滑动
    if (Math.abs(tx) > Math.abs(ty)) {
      if (tx < 0) {
        that.setData({
          status: false,
        });
      } else if (tx > 0) {
        that.setData({
          status: false,
        });
      }
    } else {  //上下方向滑动
      if (ty < 0) {
        that.setData({
          status: false,
        });
      } else if (ty > 0) {
        that.setData({
          status: true,
        });
      }
    }
    //将当前坐标进行保存以进行下一次计算
    this.data.lastX = currentX
    this.data.lastY = currentY
    that.setData({
      status: true,
    });
  },

  //滑动开始事件
  handletouchtart: function (event) {
    this.data.lastX = event.touches[0].pageX
    this.data.lastY = event.touches[0].pageY
  },
  //滑动结束事件
  handletouchend: function (event) {
    this.data.currentGesture = 0;
    this.setData({
      status: false,
    });
  },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

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