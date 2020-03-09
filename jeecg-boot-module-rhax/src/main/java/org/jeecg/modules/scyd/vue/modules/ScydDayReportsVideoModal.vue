<template>
  <a-modal
    :title="title"
    :width="width"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel"
    cancelText="关闭">
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">

        <a-form-item label="日期" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-date placeholder="请选择日期" v-decorator="[ 'date', validatorRules.date]" :trigger-change="true" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="uv" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'uv', validatorRules.uv]" placeholder="请输入uv" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="pv" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'pv', validatorRules.pv]" placeholder="请输入pv" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="订购量" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'ordernum', validatorRules.ordernum]" placeholder="请输入订购量" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="转化率" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'percent', validatorRules.percent]" placeholder="请输入转化率" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="地区ID" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'carrierid', validatorRules.carrierid]" placeholder="请输入地区ID"></a-input>
        </a-form-item>
        <a-form-item label="地区名" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'carriername', validatorRules.carriername]" placeholder="请输入地区名"></a-input>
        </a-form-item>
        <a-form-item label="自订购数据" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'fakeordernum', validatorRules.fakeordernum]" placeholder="请输入自订购数据" style="width: 100%"/>
        </a-form-item>

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>

  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import { validateDuplicateValue } from '@/utils/util'
  import JDate from '@/components/jeecg/JDate'  

  export default {
    name: "ScydDayReportsVideoModal",
    components: { 
      JDate,
    },
    data () {
      return {
        form: this.$form.createForm(this),
        title:"操作",
        width:800,
        visible: false,
        model: {},
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        confirmLoading: false,
        validatorRules: {
          date: {rules: [
            {required: true, message: '请输入日期!'},
          ]},
          uv: {rules: [
          ]},
          pv: {rules: [
          ]},
          ordernum: {rules: [
          ]},
          percent: {rules: [
          ]},
          carrierid: {rules: [
          ]},
          carriername: {rules: [
          ]},
          fakeordernum: {rules: [
          ]},
        },
        url: {
          add: "/scyd/scydDayReportsVideo/add",
          edit: "/scyd/scydDayReportsVideo/edit",
        }
      }
    },
    created () {
    },
    methods: {
      add () {
        this.edit({});
      },
      edit (record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model,'date','uv','pv','ordernum','percent','carrierid','carriername','fakeordernum'))
        })
      },
      close () {
        this.$emit('close');
        this.visible = false;
      },
      handleOk () {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            let formData = Object.assign(this.model, values);
            console.log("表单提交数据",formData)
            httpAction(httpurl,formData,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
              that.close();
            })
          }
         
        })
      },
      handleCancel () {
        this.close()
      },
      popupCallback(row){
        this.form.setFieldsValue(pick(row,'date','uv','pv','ordernum','percent','carrierid','carriername','fakeordernum'))
      },

      
    }
  }
</script>