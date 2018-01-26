// message.js

import { Main } from '../../utils/util.js'
let $ = new Main();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    obj: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    let that = this;
    let id = options.id;
    this.getList(id);
  },

  getList(id) {
    let that = this;
    let list = wx.getStorageSync('list');
    for (let i in list) {
      if (id == list[i].id) {
        console.log(list[i]);
        that.setData({
          obj: list[i]
        });
      }
    }
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