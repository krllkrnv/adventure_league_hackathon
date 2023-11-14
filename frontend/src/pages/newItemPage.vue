<template>
  <div class="main-container">
      <v-btn  :ripple="false" color="#5A5A5A" variant="text" rounded="5" prepend-icon="mdi: mdi-arrow-left" class="back-to-news-btn ma-1 ">К новостям</v-btn>
   <v-card variant="text">
     <v-card-title class="text-center text-h6" >{{newItemName}}</v-card-title>
     <v-card-subtitle>Дата публикации: {{newItemDate}}</v-card-subtitle>
     <v-card-text>{{newItemBody}}</v-card-text>
   </v-card>
  </div>
</template>

<script>

export default {
  data() {
    return {
      newItemId: 0,
      newItemDate: '01.01.2001',
      newItemName: 'Невероятно важная новость',
      newItemBody: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in blandit ante. Vestibulum dolor nisi, imperdiet in dictum eu, tincidunt sed purus. Sed turpis metus, dictum eget mi in, pellentesque lacinia augue. Fusce lacus ex, faucibus nec odio vel, tempor suscipit est. Aenean bibendum est ut nisl euismod, at sollicitudin nisi interdum. Nunc ac maximus arcu, at consequat odio. Cras lacinia libero sit amet blandit porttitor. Aliquam rutrum bibendum diam vitae commodo. Sed auctor, purus non ultricies commodo, nisl turpis placerat dolor, non commodo nulla dolor sit amet felis.\n' +
          '\n' +
          'Maecenas iaculis dapibus volutpat. Curabitur non lorem sed tellus interdum rutrum. Sed sed mattis sem. Mauris aliquam ornare magna in facilisis. Mauris laoreet porta mi quis blandit. Cras pulvinar a sapien sed finibus. In aliquet condimentum nisi, eget ornare ligula sagittis egestas. Pellentesque sed finibus nunc. Fusce ac odio at orci hendrerit facilisis. Pellentesque venenatis sem ut mauris tristique pretium. Morbi semper nunc commodo odio suscipit venenatis.\n' +
          '\n' +
          'Cras venenatis mi in sodales faucibus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi egestas libero ante, quis pretium ligula rutrum vel. Sed sollicitudin quam id nisi rhoncus tincidunt. Duis pharetra vehicula sodales. Nam faucibus dictum dui nec venenatis. Mauris vestibulum ligula sit amet ante malesuada malesuada. Proin ac urna non ex ultricies feugiat. Vivamus et dapibus purus, id vulputate quam. In pharetra pharetra est vel facilisis. Vestibulum sit amet finibus dui, ut bibendum nisi. Aliquam tellus mi, feugiat ut dapibus et, euismod eget nulla. Aenean laoreet ipsum sed ipsum placerat, vel imperdiet diam tempor. Duis quis tortor eget odio consectetur vehicula in eget mi.\n' +
          '\n' +
          'In hac habitasse platea dictumst. Proin dignissim dapibus purus, ac faucibus risus fringilla quis. Maecenas ut sapien ac dui tempus dapibus. Sed condimentum felis velit, eget semper neque accumsan sed. Cras non risus vel nisl dictum porttitor. Vestibulum auctor a magna vitae imperdiet. In posuere dolor at suscipit elementum. Ut congue ante odio, a commodo urna varius at. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed sed tempus leo, a volutpat est. Ut lorem neque, porttitor in ultricies vel, semper sed lorem. Curabitur tincidunt est quis lorem imperdiet blandit consequat a arcu. Mauris consequat dapibus feugiat. Duis in rutrum dui.\n' +
          '\n' +
          'Pellentesque semper neque ac nunc varius, a placerat tortor aliquam. In pharetra non metus at molestie. Nam dictum, erat porttitor bibendum iaculis, augue est tempus lorem, et cursus ante massa in mauris. Sed tristique purus tortor, et pharetra eros vehicula sed. Vestibulum viverra iaculis nisl. Etiam id quam non orci eleifend posuere a nec metus. Integer non orci tristique, scelerisque risus in, dictum felis.'
    }
  },
  methods: {

  },
}
</script>

<style lang="scss" scoped>

.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}


.success {
  background-color: #9CCAF0;
}
.v-card {
  width: 80%;
  flex-shrink: 0;
  border-radius: 1.5rem;
}
.back-to-news-btn{
  align-self: start;
}

</style>

<style type="css">

</style>
