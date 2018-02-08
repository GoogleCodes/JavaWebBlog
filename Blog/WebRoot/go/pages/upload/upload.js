// pages/upload/upload.js

import { Main } from '../../utils/util.js'
let $ = new Main();
let urls = require('../../utils/root.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgArrays: [],
    imagesVisible: true,
    textarea: 'some thing...'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  blurTextArea(e) {
    this.setData({
      textarea: e.detail.value,
    })
  },

  getImages() {
    let that = this;
    let status = '';
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success(res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        let tempFilePaths = res.tempFilePaths;
        let arr = [], json = {};
        for (let i in tempFilePaths) {
          wx.showLoading({
            title: '上传中...',
          })
          json = {
            path: tempFilePaths[i]
          };
          that.data.imgArrays.push(tempFilePaths[i]);
          // that.upload(tempFilePaths[i], "file");
          that.setData({
            imgArrays: that.data.imgArrays
          });
        }
        wx.hideLoading();
        if (that.data.imgArrays.length == 0) {
          that.setData({
            imagesVisible: true
          });
        } else if (that.data.imgArrays.length !== 0) {
          that.setData({
            imagesVisible: false
          });
        }
      }
    })
  },

  uploadImages() {
    let that = this;

    console.log($.formatTime(new Date()), that.data.textarea);
    for (let i in that.data.imgArrays) {
      $.uploadAjax({
        url: 'FileUploadServlet?desc=' + that.data.textarea + '&openid=' + wx.getStorageSync('wxUserInfo').openid,
        filePath: that.data.imgArrays[i],
        formData: {
          
        },
        name: 'file',
      }).then((res) => {
        if (res.statusCode == 200) {
          wx.showToast({
            title: '上传成功！',
          });
          setTimeout(() => {
            wx.switchTab({
              url: '../index/index',
            })
          }, 1000);
        }
      })
    }

  },

  previewImage(e) {
    console.log(e)
    var current = e.target.dataset.src;
    let that = this;
    wx.previewImage({
      current: current,
      urls: that.data.imgArrays,
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})