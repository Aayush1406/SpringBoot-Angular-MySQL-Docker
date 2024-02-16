FROM node:19.9.0-alpine

WORKDIR /app

COPY package.json .
COPY package-lock.json .

COPY tsconfig* .

# 3 minutes
RUN npm install 

COPY . .

EXPOSE 4200

CMD [ "npm", "run", "start" ]


# nginx static server
# multi-stage build