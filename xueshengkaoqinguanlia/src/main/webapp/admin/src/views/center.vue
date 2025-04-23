<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='fudaoyuan'"  label='辅导员姓名' prop="fudaoyuanName">
               <el-input v-model="ruleForm.fudaoyuanName"  placeholder='辅导员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='fudaoyuan'" label='头像' prop="fudaoyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.fudaoyuanPhoto?ruleForm.fudaoyuanPhoto:''"
                         @change="fudaoyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='fudaoyuan'"  label='联系方式' prop="fudaoyuanPhone">
               <el-input v-model="ruleForm.fudaoyuanPhone"  placeholder='联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='fudaoyuan'"  label='邮箱' prop="fudaoyuanEmail">
               <el-input v-model="ruleForm.fudaoyuanEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='jiaoshi'"  label='教师姓名' prop="jiaoshiName">
               <el-input v-model="ruleForm.jiaoshiName"  placeholder='教师姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='jiaoshi'" label='图片' prop="jiaoshiPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.jiaoshiPhoto?ruleForm.jiaoshiPhoto:''"
                         @change="jiaoshiPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='jiaoshi'"  label='联系方式' prop="jiaoshiPhone">
               <el-input v-model="ruleForm.jiaoshiPhone"  placeholder='联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='jiaoshi'"  label='邮箱' prop="jiaoshiEmail">
               <el-input v-model="ruleForm.jiaoshiEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='kaoqinguanli'"  label='院系考勤管理姓名' prop="kaoqinguanliName">
               <el-input v-model="ruleForm.kaoqinguanliName"  placeholder='院系考勤管理姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='kaoqinguanli'" label='头像' prop="kaoqinguanliPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.kaoqinguanliPhoto?ruleForm.kaoqinguanliPhoto:''"
                         @change="kaoqinguanliPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='kaoqinguanli'"  label='联系方式' prop="kaoqinguanliPhone">
               <el-input v-model="ruleForm.kaoqinguanliPhone"  placeholder='联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='kaoqinguanli'"  label='邮箱' prop="kaoqinguanliEmail">
               <el-input v-model="ruleForm.kaoqinguanliEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生姓名' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='学生姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='联系方式' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='学生身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'"  label='专业' prop="zhuanyeTypes">
                 <el-select v-model="ruleForm.zhuanyeTypes"  placeholder='请选择专业'>
                     <el-option
                             v-for="(item,index) in zhuanyeTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 学生
    // 注册的类型字段 学生
        // 性别
        sexTypesOptions : [],
        // 专业
        zhuanyeTypesOptions : [],
// 注册表 辅导员
    // 注册的类型字段 辅导员
        // 性别
        sexTypesOptions : [],
// 注册表 教师
    // 注册的类型字段 教师
        // 性别
        sexTypesOptions : [],
// 注册表 院系考勤管理
    // 注册的类型字段 院系考勤管理
        // 性别
        sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 学生
// 注册表 辅导员
// 注册表 教师
// 注册表 院系考勤管理
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 学生 的级联表
// 注册表 辅导员 的级联表
// 注册表 教师 的级联表
// 注册表 院系考勤管理 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhuanye_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.zhuanyeTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    fudaoyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.fudaoyuanPhoto = fileUrls;
    },
    jiaoshiPhotoUploadChange(fileUrls) {
        this.ruleForm.jiaoshiPhoto = fileUrls;
    },
    kaoqinguanliPhotoUploadChange(fileUrls) {
        this.ruleForm.kaoqinguanliPhoto = fileUrls;
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.fudaoyuanName)&& 'fudaoyuan'==this.flag){
                             this.$message.error('辅导员姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.fudaoyuanPhoto)&& 'fudaoyuan'==this.flag){
                             this.$message.error('头像不能为空');
                             return
                         }

                         if((!this.ruleForm.fudaoyuanPhone)&& 'fudaoyuan'==this.flag){
                             this.$message.error('联系方式不能为空');
                             return
                         }

                             if( 'fudaoyuan' ==this.flag && this.ruleForm.fudaoyuanEmail&&(!isEmail(this.ruleForm.fudaoyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.jiaoshiName)&& 'jiaoshi'==this.flag){
                             this.$message.error('教师姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.jiaoshiPhoto)&& 'jiaoshi'==this.flag){
                             this.$message.error('图片不能为空');
                             return
                         }

                         if((!this.ruleForm.jiaoshiPhone)&& 'jiaoshi'==this.flag){
                             this.$message.error('联系方式不能为空');
                             return
                         }

                             if( 'jiaoshi' ==this.flag && this.ruleForm.jiaoshiEmail&&(!isEmail(this.ruleForm.jiaoshiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.kaoqinguanliName)&& 'kaoqinguanli'==this.flag){
                             this.$message.error('院系考勤管理姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.kaoqinguanliPhoto)&& 'kaoqinguanli'==this.flag){
                             this.$message.error('头像不能为空');
                             return
                         }

                         if((!this.ruleForm.kaoqinguanliPhone)&& 'kaoqinguanli'==this.flag){
                             this.$message.error('联系方式不能为空');
                             return
                         }

                             if( 'kaoqinguanli' ==this.flag && this.ruleForm.kaoqinguanliEmail&&(!isEmail(this.ruleForm.kaoqinguanliEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('学生姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('头像不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhone)&& 'yonghu'==this.flag){
                             this.$message.error('联系方式不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('学生身份证号不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.zhuanyeTypes)&& 'yonghu'==this.flag){
                             this.$message.error('专业不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes) && this.flag!='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
