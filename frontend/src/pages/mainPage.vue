<template>
    <div class="container">
        <div class="main-container">
            <v-card
            variant="flat"
            class="main-page-greeting-card"
            ><v-img
                src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
                height="200px"
                cover
            ></v-img>
                <v-card-title
                    class="text-h6 text-center"
                >
                    Добро пожаловать в Корпоративный университет
                </v-card-title>
                <v-card-text>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</v-card-text>
            </v-card>
            <div class="main-page-row">
                <v-row justify="space-around" class="v-row-element">
                <v-col><v-card rounded="5" elevation="5" variant="text" class="v-card-element">

                    <v-card-title class="text-center">This is title</v-card-title>
                    <v-card-subtitle class="text-center">This is subtitle</v-card-subtitle>
                    <v-card-text>Columns will automatically take up an equal amount of space within their parent container. This can be modified using the cols prop. You can also utilize the sm, md, lg, and xl props to further define how the column will be sized in different viewport sizes.</v-card-text>
                </v-card>
                </v-col>
                <v-col><v-card rounded="5" elevation="5" variant="text" class="v-card-element">
                    <v-card-title class="text-center">This is title</v-card-title>
                    <v-card-subtitle class="text-center">This is subtitle</v-card-subtitle>
                    <v-card-text>Columns will automatically take up an equal amount of space within their parent container. This can be modified using the cols prop. You can also utilize the sm, md, lg, and xl props to further define how the column will be sized in different viewport sizes.</v-card-text>
                </v-card></v-col>
                <v-col><v-card rounded="5" elevation="5" variant="text" class="v-card-element">
                    <v-card-title class="text-center">This is title</v-card-title>
                    <v-card-subtitle class="text-center">This is subtitle</v-card-subtitle>
                    <v-card-text>Columns will automatically take up an equal amount of space within their parent container. This can be modified using the cols prop. You can also utilize the sm, md, lg, and xl props to further define how the column will be sized in different viewport sizes.</v-card-text>
                </v-card>
                </v-col>
            </v-row>
                <v-row justify="space-around" class="v-row-element">
                    <v-col><v-card rounded="5" elevation="5" variant="text" class="v-card-element">
                        <v-card-title class="text-center">This is title</v-card-title>
                        <v-card-subtitle class="text-center">This is subtitle</v-card-subtitle>
                        <v-card-text>Columns will automatically take up an equal amount of space within their parent container. This can be modified using the cols prop. You can also utilize the sm, md, lg, and xl props to further define how the column will be sized in different viewport sizes.</v-card-text>
                    </v-card>
                    </v-col>
                    <v-col><v-card rounded="5" elevation="5" variant="text" class="v-card-element">
                        <v-card-title class="text-center">This is title</v-card-title>
                        <v-card-subtitle class="text-center">This is subtitle</v-card-subtitle>
                        <v-card-text>Columns will automatically take up an equal amount of space within their parent container. This can be modified using the cols prop. You can also utilize the sm, md, lg, and xl props to further define how the column will be sized in different viewport sizes.</v-card-text>
                    </v-card></v-col>
                </v-row>
            </div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.main-container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.main-page-greeting-card {
    flex-shrink: 0;
    border-radius: 1.5rem;
    margin: 1rem;
    background: #d3e0f5;
    width: 100%;
}
.main-page-row{
    margin-bottom: 1rem;
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
}
.v-card-element{
    transition: transform 0.3s ease-in-out;
}

.v-card-element:hover{
    transform: scale(1.05);
}
.v-card-title {
    color: #5A5A5A;
    font-size: 1.25rem;
    font-style: normal;
    font-weight: 600;
    line-height: normal;
}

.v-card-text {
    color: #020B3B;
    font-size: 0.875rem;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
}
</style>