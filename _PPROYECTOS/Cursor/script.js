import { parse } from "./parseAni";

const div = document.createElement("div");
div.style.height = "100px";
div.style.width = "100px";
div.style.backgroundColor = "pink";
document.body.appendChild(div);

function animateJs(node, { urls, iDispRate }) {
  const frames = urls.map((url) => {
    return { cursor: `url(${url}), auto` };
  });
  const frameDurationMs = iDispRate * 16;
  return node.animate(frames, {
    duration: frameDurationMs * frames.length,
    iterations: Infinity
  });
}

let id = 0;
function uniqueId() {
  return id++;
}

function animateCss(node, { urls, iDispRate }) {
  const animationName = `ani-${uniqueId()}`;
  const frames = urls.map((url, i) => {
    const percent = (i / (urls.length - 1)) * 100;
    return `${percent}% { cursor: url(${url}), auto; }`;
  });
  const durationMs = iDispRate * 16 * frames.length;
  const style = document.createElement("style");
  style.innerHTML = `@keyframes ${animationName} { ${frames.join("\n")} }`;
  console.log(style.innerHTML);
  document.head.appendChild(style);
  node.style.animation = `${animationName} ${durationMs}ms infinite`;
}

async function main() {
  const response = await fetch("0001.ani");
  const body = await response.arrayBuffer();
  const arr = new Uint8Array(body);
  const ain = parse(arr);
  animateCss(div, ain);
  // animateJs(div, ain);
}

main();
