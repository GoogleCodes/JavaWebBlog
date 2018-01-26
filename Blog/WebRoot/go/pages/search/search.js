
import { Main } from '../../utils/util.js'
let $ = new Main();

// search.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    search: '',
    list: [],
    src: ['https://getcodeing.com/static/images/abc.jpg']
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  getText(e) {
    let that = this;
    this.setData({
      search: e.detail.value
    });
    if (e.detail.value == '') {
      wx.showToast({
        title: '请输入内容!',
        duration: 2000,
      })
    } else {
      wx.showLoading({
        title: '获取中。。。',
      })
      $.ajax({
        url: 'SearchServlet',
        method: "POST",
        data: {
          content: that.data.search
        },
      }).then((res) => {
        if (res.items.length == 0) {
          wx.showToast({
            title: '暂时没有内容!',
          })
          return false;
        }
        that.setData({
          list: res.items
        });
        wx.hideLoading();
      });
    }
  },

  previewImage(e) {
    var current = e.target.dataset.src;
    let that = this;
    wx.previewImage({
      current: current,
      urls: that.data.src,
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