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

        <a-form-item label="year" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'year', validatorRules.year]" placeholder="请输入year"></a-input>
        </a-form-item>
        <a-form-item label="月份" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'month', validatorRules.month]" placeholder="请输入月份"></a-input>
        </a-form-item>
        <a-form-item label="佣金/主营收入" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'mainIncome', validatorRules.mainIncome]" placeholder="请输入佣金/主营收入" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="其他收入" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'otherIncome', validatorRules.otherIncome]" placeholder="请输入其他收入" style="width: 100%"/>
        </a-form-item>

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>

  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import { validateDuplicateValue } from '@/utils/util'

  export default {
    name: "JeecgMonthlyGrowthAnalysisModal",
    components: { 
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
          year: {rules: [
          ]},
          month: {rules: [
          ]},
          mainIncome: {rules: [
          ]},
          otherIncome: {rules: [
          ]},
        },
        url: {
          add: "/scdx/jeecgMonthlyGrowthAnalysis/add",
          edit: "/scdx/jeecgMonthlyGrowthAnalysis/edit",
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
          this.form.setFieldsValue(pick(this.model,'year','month','mainIncome','otherIncome'))
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
        this.form.setFieldsValue(pick(row,'year','month','mainIncome','otherIncome'))
      },

      
    }
  }
</script>